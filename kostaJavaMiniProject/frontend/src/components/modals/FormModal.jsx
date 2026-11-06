import { useEffect, useState } from 'react'
import useDialog from './useDialog'

/**
 * 관리자 화면에서 쓰는 범용 입력 모달.
 * fields: [{ name, label, type('text'|'password'|'textarea'|'select'|'datetime-local'|'tel'), value, options:[{value,label}], placeholder, maxLength, required }]
 */
export default function FormModal({ open, eyebrow, title, description, fields, submitLabel, onSubmit, onClose }) {
  const dialogRef = useDialog(open)
  const [values, setValues] = useState({})

  useEffect(() => {
    if (!open) return
    setValues(Object.fromEntries((fields ?? []).map(f => [f.name, f.value ?? ''])))
  }, [open, fields])

  const update = name => e => setValues(prev => ({ ...prev, [name]: e.target.value }))

  const handleSubmit = e => {
    e.preventDefault()
    onSubmit(values)
  }

  return (
    <dialog id="formModal" ref={dialogRef} onClose={onClose}>
      <form className="modal-card" id="formModalForm" onSubmit={handleSubmit}>
        <button className="modal-close" type="button" aria-label="닫기" onClick={onClose}>×</button>
        <p className="eyebrow">{eyebrow}</p>
        <h3>{title}</h3>
        {description && <p className="modal-desc">{description}</p>}
        {(fields ?? []).map(f => (
          <label key={f.name}>{f.label}
            {f.type === 'textarea' ? (
              <textarea name={f.name} rows={4} required={f.required !== false} maxLength={f.maxLength} placeholder={f.placeholder} value={values[f.name] ?? ''} onChange={update(f.name)} />
            ) : f.type === 'select' ? (
              <select name={f.name} required={f.required !== false} value={values[f.name] ?? ''} onChange={update(f.name)}>
                {(f.options ?? []).map(o => <option key={o.value} value={o.value}>{o.label}</option>)}
              </select>
            ) : (
              <input name={f.name} type={f.type ?? 'text'} required={f.required !== false} maxLength={f.maxLength} placeholder={f.placeholder}
                autoComplete={f.type === 'password' ? 'new-password' : 'off'} value={values[f.name] ?? ''} onChange={update(f.name)} />
            )}
          </label>
        ))}
        <button className="btn primary wide" id="formModalSubmit" type="submit">{submitLabel ?? '저장'}</button>
      </form>
    </dialog>
  )
}
