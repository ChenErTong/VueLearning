import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import CsvTable from '@/components/CsvTable'

Vue.use(Router)

export default new Router({
  mode: 'history',
  hashbang: false,
  history: true,
  routes: [
    {
      path: '/',
      component: HelloWorld
    },
    {
      path: '/table',
      component: CsvTable
    }
  ]
})
