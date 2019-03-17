<template>
  <el-row>
    <el-col :span="20">
      <cats-list />
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

    <cat-form
      ref="form"
    />
  </el-row>
  
</template>

<script>
import CatsList from './List'
import CatForm from './Form'
import { mapGetters, mapActions } from 'vuex'

export default {
  created() {
    this.loadCategories()
  },

  components: {
    CatsList,
    CatForm
  },

  methods: {
    ...mapActions('Categories', [
      'loadCategories'
    ]),

    openForm() {
      this.$refs.form.openDialog()
    }
  }
}
</script>