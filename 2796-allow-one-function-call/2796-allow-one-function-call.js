/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {
    // we are using a closer or flag that store initially false , if it become true then it menas it is used earlier

    let isCalled=false;
    let result;

    return function(...args){
        if(!isCalled){
            result=fn(...args)
            isCalled = true;
            return result;

        }
        else{
            return undefined;
        }
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
