/**
 * @param {number} millis
 * @return {Promise}
 */
 function shujawrite(millis) {
    let p = new Promise(function (resolve) {
        setTimeout(resolve ,millis)
    })
    return p;
}
async function sleep(millis) {
    let value=shujawrite(millis)
     return value;
    
}


/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */