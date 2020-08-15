const app = new Vue({
    el: "#app",
    data() {
        return {
            uName: "",
            uPwd: "",
        }
    },
    methods: {
        login() {
            let regName = /^[A-Za-z0-9]{4,15}$/;
            let regPwd = /((?=.*\d)(?=.*\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$/;
            if (regName.test(this.uName) && regPwd.test(this.uPwd)) {
                axios(
                    {
                        method: "post",
                        url: "/userLogin",
                        transformRequest: [
                            function (data) {
                                return parseParams(data);
                            }
                        ],
                        data: {
                            uName: this.uName,
                            uPwd: this.uPwd
                        }
                    }).then((response) => {
                        if (response.data) {
                            this.loginSuccess();
                        } else {
                            this.loginError();
                        }
                    }
                )
            } else {
                this.inputNoData();
            }
        },
        register() {
            window.location.replace("http://localhost/register")

        },
        retrieve() {
            window.location.replace("http://localhost/retrieve")
        }
        ,
        loginSuccess() {
            window.location.replace("http://localhost/index")
        },
        loginError() {
            this.$notify.error({
                title: '登录失败',
                message: '请检查账号名和密码是否正确',
                position: 'bottom-right'
            });
        },
        inputNoData() {
            this.$alert('请输入完整的用户名或密码;用户名只能包括数字字母的组合，长度为4-15位;' +
                '密码长度在6~18之间，只能包含字母、数字和下划线', '用户名或密码格式错误', {
                confirmButtonText: '确定'
            });
        }
    }
});
