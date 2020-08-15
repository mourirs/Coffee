const app = new Vue({
    el:"#app",
    methods:{
        shoppingCar(){
            window.location.replace("http://localhost/shoppingCar")
        },
        order(){
            window.location.replace("http://localhost/orderInFo")
        },
        shopping(){
            window.location.replace("http://localhost/shopping")
        }
    }
})