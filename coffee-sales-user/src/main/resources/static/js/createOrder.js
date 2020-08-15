const corder = {
    template: "#corder",
    data() {
        return {
            value: '',
            address: {},
            orderInFo: [],
            orderInFoArray: []
        }
    },
    methods: {
        addressAllInFo() {
            axios.post("/addressList").then((response) => {
                this.address = response.data;
            })
        },
        addressHandle(value) {
            return "收件人：" + value.consignee + " " +
                "电话：" + value.consigneePhone + " " +
                "住址：" + value.area + " " +
                "详细住址：" + value.detailedArea;
        },
        createOrder() {
            let order = JSON.stringify(this.orderInFoArrayCopy());
            axios({
                method: "post",
                url: "/addOrderInFos",
                transformRequest: [
                    function (data) {
                        return parseParams(data);
                    }
                ],
                data: {
                    order: order
                }
            }).then((response) => {
                if (response.data) {
                    sessionStorage.removeItem("shoppingCar");
                    window.location.replace("http://localhost/orderInFo")
                } else {
                    this.$notify({
                        title: '订单创建失败',
                        message: '请稍后重试！',
                        position: 'bottom-right'
                    });
                }
            });
        },
        orderInFoArrayCopy() {
            let orderArray = [];
            for (let i = 0; i < this.orderInFo.length; i++) {
                let order = {
                    cId: '',
                    oNumber: '',
                    oGold: '',
                    oTransaction: 1,
                    aId: '',
                    oName: '',
                    oPrice: '',
                    oNUm: ''
                };
                order.cId = this.orderInFo[i].cid;
                order.oNumber = this.orderNumber();
                order.oGold = this.orderInFo[i].cnum * this.orderInFo[i].commodity.yprice;
                order.aId = this.value;
                order.oName = this.orderInFo[i].commodity.yname;
                order.oPrice = this.orderInFo[i].commodity.yprice;
                order.oNUm = this.orderInFo[i].cnum;
                orderArray.push(order);
            }
            return orderArray;
        },
        orderNumber() {
            let now = new Date();
            let year = now.getFullYear();       //年
            let month = now.getMonth() + 1;     //月
            let day = now.getDate();            //日
            let hh = now.getHours();            //时
            let mm = now.getMinutes();          //分
            let ss = now.getSeconds();           //秒
            let clock = year + "";
            if (month < 10)
                clock += "0";

            clock += month + "";

            if (day < 10)
                clock += "0";

            clock += day + "";

            if (hh < 10)
                clock += "0";

            clock += hh + "";
            if (mm < 10) clock += '0';
            clock += mm + "";

            if (ss < 10) clock += '0';
            clock += ss;
            return (clock);
        },
    }, mounted() {
        this.addressAllInFo();
        this.orderInFo = JSON.parse(sessionStorage.getItem('shoppingCar'));
        console.log(this.orderInFo)
    },
    filters: {
        showPrice(price) {
            return "￥" + price.toFixed(2)
        }
    },
};
const app = new Vue({
    el: "#app",
    components: {
        corder
    }
});