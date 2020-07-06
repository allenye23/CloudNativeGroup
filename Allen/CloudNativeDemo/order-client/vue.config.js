const proxy = require('http-proxy-middleware');

module.exports = {
    devServer: {
      proxy: {
        '/api': {
          target: 'http://localhost:8991/api', //对应自己的接口
          changeOrigin: true,
          ws: true,
          pathRewrite: {
            '^/api': ''
          }
        }
      }
    }
  }

  
  