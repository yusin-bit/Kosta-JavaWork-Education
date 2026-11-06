// 원본 app.js 에 있던 상수와 작은 헬퍼 함수들

export const pageTitles = {
  dashboard: '대여 현황',
  items: '물품 관리',
  rent: '물품 대여',
  history: '반납 및 대여 내역 관리',
  account: '회원 정보 관리',
}

// 메인 화면 요약 카드(신청/대여 중/완료)를 눌렀을 때 쓰는 필터
export const rentalFilters = {
  all: { title: '반납 및 대여 내역 관리', description: '내가 빌린 물품과 내 물품에 들어온 신청을 함께 관리합니다.' },
  requested: { title: '내 대여 신청 내역', description: '현재 승인을 기다리는 내 신청입니다.', statuses: [100], borrowerOnly: true },
  renting: { title: '내 대여 중인 물품', description: '현재 실제 대여 중 상태인 내역입니다.', statuses: [110], borrowerOnly: true },
  completed: { title: '내 완료 내역', description: '내가 빌리고 반납까지 완료한 내역입니다.', statuses: [211], borrowerOnly: true },
}

// 반납 및 대여 내역 화면 상단 단계 버튼 → 해당 단계의 상태 코드
export const rentalStages = {
  'stage-all': null,
  'stage-requested': [100],
  'stage-approved': [101],
  'stage-rented': [110],
  'stage-returning': [200, 201, 210],
  'stage-completed': [211],
}

export const rentalActionLabels = {
  approve: '승인',
  reject: '거절',
  start: '대여 시작',
  'return-request': '반납 신청',
  'return-approve': '반납 승인',
  'return-confirm': '반납 거래 확인',
  complete: '최종 완료',
}

// 사진이 없는 물품에 보여줄 아이콘 (소분류 이름 기준, 없으면 대분류 키워드)
const categoryIcons = [
  [/노트북/, '💻'], [/데스크탑|모니터/, '🖥️'], [/마우스/, '🖱️'], [/키보드/, '⌨️'],
  [/스마트폰|태블릿|폰/, '📱'], [/워치/, '⌚'], [/이어폰|헤드폰/, '🎧'], [/스피커/, '🔊'],
  [/DSLR|미러리스|카메라/, '📷'], [/액션캠|웹캠/, '📹'], [/프로젝터/, '📽️'],
  [/닌텐도|엑스박스|게임/, '🎮'], [/공기청정/, '🌬️'], [/청소기/, '🧹'], [/전자책/, '📖'],
  [/공구/, '🧰'], [/캠핑|생활/, '⛺'], [/디지털|모바일/, '📱'],
]

export const iconFor = category => categoryIcons.find(([pattern]) => pattern.test(category ?? ''))?.[1] ?? '📦'

// 소분류 코드로 { big, small } 카테고리 정보를 찾는다.
export const categoryInfo = (categoryTree, smallCode) => {
  for (const big of categoryTree ?? []) {
    const small = big.children.find(child => child.code === smallCode)
    if (small) return { big, small }
  }
  return null
}

export const displayNameOf = user => user.nickname || user.name || user.id
