<template>
  <a-form :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }" @submit="handleSubmit">
    <a-form-item label="good name">
      <a-input
        v-decorator="['note', { rules: [{ required: true, message: 'Please input your note!' }] }]" v-model='order.goodName'
      />
    </a-form-item>
    <a-form-item label="count">
      <a-input-number :min="0" :max="1200" v-model='order.count' />
    </a-form-item>
        <a-form-item label="price">
      <a-input-number :min="0" :max="1200" v-model='order.price' />
    </a-form-item>
     <a-form-item label="address">
      <a-input
        v-decorator="['note', { rules: [{ required: true, message: 'Please input your note!' }] }]" v-model='order.address'
      />
    </a-form-item>
    <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
      <a-button type="primary" html-type="submit">
        Submit
      </a-button>
    </a-form-item>
  </a-form>
</template>

<script>

export default {
  name: 'App',
   data() {
    return {
      order:{
        goodName:'',
        count: 0,
        price: 0,
        address: '',
        status: 'pending'
      }
    };
  },
  methods: {
    handleSubmit(e) {
      e.preventDefault();
      this.$axios({
        method:'post',
        url:'/api/order',
        data: this.order,
      }).then(function(response){
        console.log(response);
        alert('success')
      }).catch(error=>{
         alert(error)
      })
    },
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
