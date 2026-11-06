// 업로드 전에 브라우저에서 사진을 줄인다.
// 휴대폰 사진(수 MB)도 긴 변 1000px JPEG(보통 100~250KB)로 바꿔 보내서 업로드가 빠르고 서버 부담이 적다.
// (서버도 다시 검사·변환하므로 이 단계는 편의용이지 보안 검사가 아니다)

const MAX_SIDE = 1000
const MAX_BYTES = 480 * 1024 // 서버 한도 512KB 보다 조금 작게

export async function compressImage(file) {
  if (!file?.type?.startsWith('image/')) throw new Error('사진 파일만 선택할 수 있습니다.')
  let bitmap
  try {
    // imageOrientation: 휴대폰 사진의 회전 정보를 반영해서 그린다
    bitmap = await createImageBitmap(file, { imageOrientation: 'from-image' })
  } catch {
    throw new Error('이 사진 형식은 열 수 없습니다. JPG 또는 PNG 로 올려주세요.')
  }
  const scale = Math.min(1, MAX_SIDE / Math.max(bitmap.width, bitmap.height))
  const canvas = document.createElement('canvas')
  canvas.width = Math.max(1, Math.round(bitmap.width * scale))
  canvas.height = Math.max(1, Math.round(bitmap.height * scale))
  const ctx = canvas.getContext('2d')
  ctx.fillStyle = '#fff' // 투명 PNG 는 흰 배경
  ctx.fillRect(0, 0, canvas.width, canvas.height)
  ctx.drawImage(bitmap, 0, 0, canvas.width, canvas.height)
  bitmap.close?.()

  for (const quality of [0.85, 0.75, 0.65, 0.5]) {
    const blob = await new Promise(resolve => canvas.toBlob(resolve, 'image/jpeg', quality))
    if (blob && blob.size <= MAX_BYTES) return blob
  }
  throw new Error('사진이 너무 큽니다. 다른 사진을 선택해주세요.')
}
