//bai1
var multiply = (num1, num2) => {
  console.log(num1 * num2);
  return num1 * num2;
};
multiply(1, 2);

var toCelsius = (fahrenheit) => {
  console.log((5 / 9) * (fahrenheit - 32));
  return (5 / 9) * (fahrenheit - 32);
};
toCelsius(33);

var padZeros = (num, totalLen) => {
  var numStr = num.toString();
  var numZeros = totalLen - numStr.length;
  for (var i = 1; i <= numZeros; i++) {
    numStr = "0" + numStr;
  }
  return numStr;
};

var power = (base, exponent) => {
  var result = 1;
  for (var i = 0; i < exponent; i++) {
    result *= base;
  }
  console.log(result);
  return result;
};
power(2, 5);

var greet = (who) => {
  console.log("Hello" + who);
};

//bai2
var count = () => {
  let a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
  let tong = 0;
  for (let i = 0; i < a.length; i++) {
    if (a[i] % 20 != 0) {
      tong += a[i];
    }
  }
  console.log(tong);
  return tong;
};
count();
