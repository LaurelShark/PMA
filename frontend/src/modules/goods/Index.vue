<template>
  <el-row>
    <el-col :span="20">
      <goods-list />
    </el-col>
    <el-col :span="4">
      <el-button
        type="primary"
        icon="el-icon-plus"
        @click="openForm"
      >
        Create
      </el-button>
    </el-col>
    <form-wrapper ref="form">
      <good-form
        @update="onUpdate"
      />
    </form-wrapper>
  </el-row>
  
</template>

<script>
import GoodsList from './List'
import GoodForm from './Form'
import { mapActions } from 'vuex'

export default {
  created() {
    this.loadGoods()
  },

  components: {
    GoodsList,
    GoodForm
  },

  methods: {
     ...mapActions('Goods', [
      'loadGoods'
    ]),

    onUpdate() {
      this.loadGoods()
      this.closeForm()
    },

    openForm() {
      this.$refs.form.openForm()
    },

    closeForm() {
      this.$refs.form.closeForm()
    }
  },
}
</script>