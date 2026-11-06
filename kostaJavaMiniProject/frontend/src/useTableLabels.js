import { useEffect } from 'react'

// 휴대폰에서는 표를 카드 모양으로 보여주므로, 각 칸에 머리글(th) 이름을 data-label 로 붙여 둔다.
// (CSS 의 td::before { content: attr(data-label) } 가 이 값을 이름표로 표시)
export default function useTableLabels() {
  useEffect(() => {
    document.querySelectorAll('.table-wrap table').forEach(table => {
      const heads = [...table.querySelectorAll('thead th')].map(th => th.textContent.trim())
      table.querySelectorAll('tbody tr').forEach(tr => {
        ;[...tr.children].forEach((td, i) => {
          const label = td.colSpan > 1 ? '' : heads[i] ?? ''
          if (td.dataset.label !== label) td.dataset.label = label
        })
      })
    })
  })
}
