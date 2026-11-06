export default function Toast({ message, show }) {
  return <div className={`toast${show ? ' show' : ''}`} id="toast" role="status">{message}</div>
}
