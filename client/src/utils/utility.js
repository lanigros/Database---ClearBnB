export const createAmenityArray = (wifi, kitchen, bath, parking) => {
  let amenityArray = []
  if (wifi) amenityArray.push('WIFI')
  if (kitchen) amenityArray.push('KITCHEN')
  if (bath) amenityArray.push('BATH')
  if (parking) amenityArray.push('PARKING')
  return amenityArray
}
