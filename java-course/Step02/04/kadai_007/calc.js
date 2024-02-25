// 1～100のランダムな正数を代入
let num = Math.ceil(Math.random() * 100);

// 商を算出
let quotient3 = num % 3;
let quotient5 = num % 5;

// 分岐処理
if (quotient3 === 0 && quotient5 === 0){
  console.log('3と5の倍数です');
} else if (quotient3 === 0) {
  console.log('3の倍数です');
} else if (quotient5 === 0) {
  console.log('5の倍数です');
} else {
  console.log(num);
}