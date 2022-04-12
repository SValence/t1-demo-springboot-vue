export default {
    // 这一句可不用写了, 因为 package.json 中已经关闭了检测未使用变量功能
    // "rules": {
    //      "no-unused-vars": [1, {"vars": "all", "args": "after-used"}]
    //  }
    // eslint-disable-next-line
    install(Vue, options) {
        Vue.prototype.global = {
            postHeadersUrlEn:{'Content-Type': 'application/x-www-form-urlencoded'}
        };
    }
}
