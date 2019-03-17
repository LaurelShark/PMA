import Vue from "vue";
import Vuex from "vuex";
import Categories from './categories'

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    Categories
  }
});
