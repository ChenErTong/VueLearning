<template>
  <form @submit.prevent="submit" enctype="multipart/form-data" style="margin:2% auto">
    <input type='file' name='file' accept=".csv" @change="onFileChange"/>
    <input type="submit" name="submit" value="上传" />
    <table border="1px" width="80%" style="margin:2% auto" v-show="isShow">
      <tr>
        <td v-for="h in header" :key="h">{{ h }}</td>
      </tr>
      <tr v-for="row in rows" :key="row[0]">
        <td v-for="r in row" :key="r">{{ r }}</td>
      </tr>
    </table>
  </form>
</template>

<script>
import axios from 'axios'
export default {
  name: 'csv-table',
  data: function () {
    return {
      file: {},
      header: [],
      rows: [],
      isShow: false
    }
  },
  methods: {
    onFileChange (e) {
      this.file = e.target.files[0]
      console.log(this.file)
    },
    submit (e) {
      var formData = new FormData()
      formData.append('file', this.file)
      axios({
        url:'/upload',
        method: 'post',
        data: formData
      }).then((res) =>{
        this.header = res.data.header
        this.rows = res.data.rows
        this.isShow = true
      })
    }
  }
}
</script>
<style scoped>
</style>
