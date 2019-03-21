import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadCategories({ commit }) {
    try {
      const resp = await axios.get(`${API}/categories`)
      commit('processCategories', resp)
    } catch(e) {
      console.log('CATEGORIES ERROR', e)
    }
   
  }
}