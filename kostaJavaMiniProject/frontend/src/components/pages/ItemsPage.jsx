import { useState } from 'react'
import { categoryInfo } from '../../constants'
import ItemPhoto from '../ItemPhoto'

const itemFilters = [
  { key: 'all', label: '전체' },
  { key: 'available', label: '대여 가능' },
  { key: 'renting', label: '대여 중' },
]

const matchesFilter = (item, filter) => filter === 'all' || (filter === 'available') === item.available

// DB 의 "2026-10-08 10:00:00" → "10/08 10:00"
const shortDate = value => (value ? value.slice(5, 16).replace('-', '/') : '-')

export default function ItemsPage({ active, myItems, myPosts, categoryTree, onCreate, onEdit, onDelete, onCreatePost, onEditPost, onDeletePost }) {
  const [query, setQuery] = useState('')
  const [myItemFilter, setMyItemFilter] = useState('all')

  const keyword = query.trim().toLowerCase()
  const filtered = myItems.filter(item => matchesFilter(item, myItemFilter) && item.itemName.toLowerCase().includes(keyword))

  return (
    <section className={`page${active ? ' active' : ''}`} data-page-panel="items">
      <div className="section-row">
        <div><p className="eyebrow">ITEM MANAGEMENT</p><h3>내 물품 관리</h3><p>등록한 물품을 조회하고 상태를 관리합니다. 대여 글을 올려야 다른 회원의 대여 목록에 표시됩니다.</p></div>
        <button className="btn primary" id="openItemModal" onClick={onCreate}>+ 물품 등록</button>
      </div>

      <div className="filter-bar">
        <input type="search" id="myItemSearch" placeholder="물품명 검색" value={query} onChange={e => setQuery(e.target.value)} />
        <div className="segmented" id="myItemFilters">
          {itemFilters.map(f => (
            <button key={f.key} className={myItemFilter === f.key ? 'active' : undefined} type="button" onClick={() => setMyItemFilter(f.key)}>
              {f.label} <span>{myItems.filter(item => matchesFilter(item, f.key)).length}</span>
            </button>
          ))}
        </div>
      </div>

      <div className="table-wrap">
        <table>
          <thead><tr><th>물품</th><th>카테고리</th><th>상태</th><th>대여 글</th><th>관리</th></tr></thead>
          <tbody id="myItemRows">
            {filtered.length ? filtered.map(item => {
              const category = categoryInfo(categoryTree, item.smallCategoryCode)
              const status = item.available ? 'available' : 'renting'
              const post = (myPosts ?? []).find(p => p.itemNum === item.itemNum)
              return (
                <tr key={item.itemNum} data-item-status={status}>
                  <td><div className="item-cell"><ItemPhoto itemNum={item.itemNum} version={item.imageVersion} category={category?.small.name} alt={item.itemName} className="item-thumb" /><b>{item.itemName}</b></div></td>
                  <td>{category ? `${category.big.name} · ${category.small.name}` : item.smallCategoryCode}</td>
                  <td><span className={`status-chip ${status}`}>{item.available ? '대여 가능' : '대여 중'}</span></td>
                  <td>
                    {post ? (
                      <>
                        <b>{post.title}</b>
                        <small>{shortDate(post.rentDate)} ~ {shortDate(post.returnDate)} · {post.addr}</small>
                        <button className="table-action" onClick={() => onEditPost(item, post)}>글 수정</button>{' '}
                        <button className="table-action danger" onClick={() => onDeletePost(post)}>글 삭제</button>
                      </>
                    ) : (
                      <button className="table-action" onClick={() => onCreatePost(item)}>+ 대여 글 올리기</button>
                    )}
                  </td>
                  <td>
                    <button className="table-action" onClick={() => onEdit(item)}>수정</button>{' '}
                    <button className="table-action danger" onClick={() => onDelete(item)}>삭제</button>
                  </td>
                </tr>
              )
            }) : <tr><td colSpan={5}>조건에 맞는 내 물품이 없습니다.</td></tr>}
          </tbody>
        </table>
      </div>
    </section>
  )
}
