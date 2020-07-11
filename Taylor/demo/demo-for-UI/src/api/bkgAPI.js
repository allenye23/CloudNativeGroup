import axios from 'axios'

export default {
  createBkgNum(bkgNum) {
    return axios({
      method: 'post',
      url: '/api/booking/create/?bkgNum='+bkgNum
    });
  },
  searchBkgNum(bkgNum) {
    return axios({
      method: 'post',
      url: '/api/finding/search?bkgNum='+bkgNum
    });
  }
}
