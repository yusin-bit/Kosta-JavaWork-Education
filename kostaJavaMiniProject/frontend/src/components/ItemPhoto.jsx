import { useState } from 'react'
import { imageUrl } from '../api'
import { iconFor } from '../constants'

// 물품 사진. 사진이 없거나 불러오지 못하면 카테고리 아이콘을 보여준다.
// itemNum·version 은 목록 API 의 imageItemNum(또는 itemNum)·imageVersion
export default function ItemPhoto({ itemNum, version, category, alt, className = 'item-photo' }) {
  const [failedSrc, setFailedSrc] = useState(null)
  const src = imageUrl(itemNum, version)
  if (!src || failedSrc === src) return <span className={`${className} placeholder`} aria-hidden="true">{iconFor(category)}</span>
  return <img className={className} src={src} alt={alt} loading="lazy" decoding="async" onError={() => setFailedSrc(src)} />
}
