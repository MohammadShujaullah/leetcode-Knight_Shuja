/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
     let Arr=[];
    for(let i=0;i<arr.length;i++){
        if(fn(arr[i],i)){
            Arr.push(arr[i]);
        }
    }
    return Arr;
};