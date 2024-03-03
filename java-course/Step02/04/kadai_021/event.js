const btn = document.getElementById('btn');

btn.addEventListener('click', () => {
  const text = document.getElementById('text');

  setTimeout(() => {
    text.innerHTML = 'ボタンをクリックしました';
  },2000)
})