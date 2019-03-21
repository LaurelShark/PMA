import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadProviders({ commit }) {
    try {
      const resp = await axios.get(`providers`)
      commit('processProviders', resp.data)
    } catch(e) {
      console.log('PROVIDERS ERROR', e)
    }
   
  }
}