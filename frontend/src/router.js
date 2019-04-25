import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";

import GoodsList from '@/modules/goods/Index'
import CatsList from '@/modules/categories/Index'
import ReceiptsList from '@/modules/receipts/Index'
import UsersList from '@/modules/users/Index'
import ProvidersList from '@/modules/providers/Index'
import SuppliesList from '@/modules/supplies/Index'
import OrdersList from '@/modules/orders/Index'

Vue.use(Router);

export default new Router({

  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: Home,
      redirect: { name: 'goods'}
    },
    {
      path: '/goods',
      name: 'goods',
      component: GoodsList,
      meta: {
        menu: true,
        label: 'Goods',
        icon: 'el-icon-goods'
      }
    },
    {
      path: '/categories',
      name: 'categories',
      component: CatsList,
      meta: {
        menu: true,
        label: 'Categories',
        icon: 'el-icon-more'
      }
    },
    {
      path: '/receipts',
      name: 'receipts',
      component: ReceiptsList,
      meta: {
        menu: true,
        label: 'Receipts',
        icon: 'el-icon-plus'
      }
    },
    {
      path: '/users',
      name: 'users',
      component: UsersList,
      meta: {
        menu: true,
        label: 'Users',
        icon: 'el-icon-star-on'
      }
    },
    {
      path: '/providers',
      name: 'providers',
      component: ProvidersList,
      meta: {
        menu: true,
        label: 'Providers',
        icon: 'el-icon-phone'
      }
    },
    {
      path: '/supplies',
      name: 'supplies',
      component: SuppliesList,
      meta: {
        menu: true,
        label: 'Supplies',
        icon: 'el-icon-sold-out'
      }
    },
    {
      path: '/orders',
      name: 'orders',
      component: OrdersList,
      meta: {
        menu: true,
        label: 'Orders',
        icon: 'el-icon-tickets'
      }
    }
  ]
});
