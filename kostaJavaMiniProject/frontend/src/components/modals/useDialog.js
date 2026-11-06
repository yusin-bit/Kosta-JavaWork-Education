import { useEffect, useRef } from 'react'

// open 값에 맞춰 <dialog> 의 showModal() / close() 를 호출한다.
// (ESC 등으로 닫히면 <dialog> 의 onClose 에서 부모 상태를 false 로 맞춘다)
export default function useDialog(open) {
  const dialogRef = useRef(null)

  useEffect(() => {
    const dialog = dialogRef.current
    if (open && !dialog.open) dialog.showModal()
    if (!open && dialog.open) dialog.close()
  }, [open])

  return dialogRef
}
