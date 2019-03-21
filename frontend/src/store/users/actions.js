import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadUsers({ commit }) {
    try {
      const resp = await axios.get(`users`)
      commit('processUsers', resp.data)
    } catch(e) {
      console.log('USERS ERROR', e)
    }
   
  }
}