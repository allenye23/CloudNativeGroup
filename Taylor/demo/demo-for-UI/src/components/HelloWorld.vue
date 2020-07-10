<template>
  <div class="hello">
    <input type="text" placeholder="BKG Number" v-model="bkgNum"  @keyup.enter="createBkgNum" value="" />
    <button @click="createBkgNum">Create</button>
    <br>
    <span v-if="createSuccessResult != null" style="color: forestgreen">{{createSuccessResult}}</span>
    <span v-if="createFailedResult != null" style="color: red">{{createFailedResult}}</span>
    <br>
    <br>
    <input type="text" placeholder="BKG Number" v-model="bkgNumSearch"  @keyup.enter="searchBkgNum" value="" />
    <button @click="searchBkgNum">Search</button>
    <br>
    <span>{{searchResult}}</span>
  </div>
</template>

<script>
import bkgAPI from '../api/bkgAPI'

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      searchResult:null,
      bkgNum:null,
      bkgNumSearch: null,
      createSuccessResult:null,
      createFailedResult:null
    }
  },
  created() {
    this.bkgNum = null;
    this.searchResult = null;
    this.bkgNumSearch = null;
  },
  methods:{
    createBkgNum: function (){
      bkgAPI.createBkgNum(this.bkgNum).then(res=>{
        if(res.status === 200){
          this.createSuccessResult = 'Create Success!'
        }else{
          this.createFailedResult = 'Create Failed!'
        }
      });
    },
    searchBkgNum: function() {
      bkgAPI.searchBkgNum(this.bkgNumSearch).then(res=>{
        this.searchResult = res.data;
      });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
