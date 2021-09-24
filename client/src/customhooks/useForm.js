import { useState } from 'react'

export const useForm = (initialValues) => {
  const [values, setValues] = useState(initialValues)
  return [values, e => {
    const target = e.target
    const value = target.type === 'checkbox' ? target.checked: target.value
    setValues({
      ...values,
      [target.name]: value
    })
  }]
}
