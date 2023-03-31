let fs = require("fs");
let data = fs.readFileSync("/Users/eswar/Documents/10Xprac/ajs/output.txt", 'utf-8');
let idx = 0;
data = data.split('\n');

function readLine() {
    idx++;
    return data[idx - 1].trim();
}
function lucky_sevens(array){
    for(let i=0;i<array.length-2;i++){
        if((array[i]+array[i+1]+array[i+2])===7){
            return true
        }
    }
    return false
}
let array=readLine().split(" ").map(Number);
console.log(lucky_sevens(array))