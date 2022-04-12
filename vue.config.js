// 暂时不知道这里是什么用处
module.exports = {
    devServer: {
        // 反向代理端口地址及端口为 http://localhost:9899
        proxy: 'http://localhost:9899',
        port: 9899
    }
};
