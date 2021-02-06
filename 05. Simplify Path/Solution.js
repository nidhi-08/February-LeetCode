//JavaScript Solution
/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
    let arr = [];
    
    path.split("/").forEach(path=>{
        if(path===".."){
            arr.splice(arr.length-1, 1); 
            //remove last directory
        }
        else if(path && path !== "."){
            arr.push(path)
        }
    })
    
    return "/"+arr.join("/");
};
