import { useEffect, useState } from 'react'
import { api } from '../../api'
import ProductCard from './ProductCard'

// 콘솔 PostMenuView "게시글 검색" 과 같은 조건 (서버 /api/posts/search)
const searchTypes = [
  { value: 'title', label: '제목', placeholder: '게시글 제목' },
  { value: 'content', label: '내용', placeholder: '게시글 내용' },
  { value: 'addr', label: '거래 장소', placeholder: '예: 마포구' },
  { value: 'rentDate', label: '대여일', placeholder: '' },
  { value: 'itemNum', label: '물품 번호', placeholder: '숫자' },
]

export default function RentPage({ active, products, categoryTree, myPosts, onRent, toast }) {
  const ownPostNums = new Set((myPosts ?? []).map(p => p.postNum))
  const [query, setQuery] = useState('')
  const [bigCode, setBigCode] = useState('all')
  const [smallName, setSmallName] = useState('all')
  // 상세 검색: 결과가 있으면(null 이 아니면) 전체 목록 대신 검색 결과를 보여준다
  const [searchType, setSearchType] = useState('title')
  const [keyword, setKeyword] = useState('')
  const [searchResult, setSearchResult] = useState(null)

  // 카테고리를 새로 불러오면(로그인할 때마다) 필터를 '전체'로 되돌린다.
  useEffect(() => {
    setBigCode('all')
    setSmallName('all')
    setSearchResult(null)
  }, [categoryTree])

  const big = categoryTree?.find(category => category.code === bigCode)
  const type = searchTypes.find(t => t.value === searchType)

  const changeBig = e => {
    setBigCode(e.target.value)
    setSmallName('all')
  }

  const runSearch = async e => {
    e.preventDefault()
    try {
      const params = new URLSearchParams({ type: searchType, q: keyword.trim() })
      const data = await api(`/api/posts/search?${params}`)
      setSearchResult({ label: `${type.label} "${keyword.trim()}"`, posts: data.posts })
    } catch (error) {
      toast(error.message)
    }
  }

  const clearSearch = () => {
    setSearchResult(null)
    setKeyword('')
  }

  const renderCatalog = () => {
    if (categoryTree === null) return null
    const q = query.trim().toLowerCase()
    const bigNames = big ? big.children.map(child => child.name) : []
    const source = searchResult ? searchResult.posts : (products ?? [])
    const filtered = source.filter(p =>
      (p.itemName + p.category + p.title).toLowerCase().includes(q) &&
      (smallName !== 'all' ? p.category === smallName : bigCode === 'all' || bigNames.includes(p.category)))
    return filtered.length
      ? filtered.map(p => <ProductCard key={p.postNum} product={p} own={ownPostNums.has(p.postNum)} onRent={onRent} />)
      : <p>{searchResult ? '검색 조건에 맞는 대여 가능한 게시글이 없습니다.' : '선택한 카테고리에 대여 가능한 물품이 없습니다.'}</p>
  }

  return (
    <section className={`page${active ? ' active' : ''}`} data-page-panel="rent">
      <div className="section-row">
        <div><p className="eyebrow">BORROW ITEMS</p><h3>대여 가능한 물품</h3><p>원하는 게시글을 선택해 바로 대여를 신청하세요.</p></div>
      </div>
      <div className="filter-bar">
        <input type="search" id="itemSearch" placeholder="물품명 또는 카테고리 검색" value={query} onChange={e => setQuery(e.target.value)} />
        <select id="bigCategoryFilter" value={bigCode} onChange={changeBig}>
          <option value="all">전체 대분류</option>
          {(categoryTree ?? []).map(category => <option key={category.code} value={category.code}>{category.name}</option>)}
        </select>
        <select id="smallCategoryFilter" value={smallName} onChange={e => setSmallName(e.target.value)} disabled={!big}>
          <option value="all">전체 소분류</option>
          {big && big.children.map(child => <option key={child.code} value={child.name}>{child.name}</option>)}
        </select>
      </div>
      <form className="filter-bar" id="postSearchForm" onSubmit={runSearch}>
        <select id="postSearchType" value={searchType} onChange={e => { setSearchType(e.target.value); setKeyword('') }}>
          {searchTypes.map(t => <option key={t.value} value={t.value}>상세 검색: {t.label}</option>)}
        </select>
        <input
          id="postSearchKeyword"
          type={searchType === 'rentDate' ? 'date' : searchType === 'itemNum' ? 'number' : 'search'}
          placeholder={type.placeholder}
          required
          value={keyword}
          onChange={e => setKeyword(e.target.value)}
        />
        <button className="btn primary" type="submit">검색</button>
        {searchResult && <button className="btn outline" type="button" onClick={clearSearch}>검색 해제 ({searchResult.label})</button>}
      </form>
      <div className="catalog-grid" id="catalogGrid">{renderCatalog()}</div>
      <p className="credits-note">
        예시 물품 사진은 Wikimedia Commons 의 자유 이용 사진입니다. <a href={`${import.meta.env.BASE_URL}image-credits.html`} target="_blank" rel="noopener noreferrer">사진 출처 보기</a>
      </p>
    </section>
  )
}
