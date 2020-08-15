
const app = new Vue({
    el: "#app",
    data() {
        return {
            uId: "",
            uName: "",
            uEmail: "",
            uPhone: "",
            nUName: "",
            nUPwd: "",
            aNUPwd: "",
            nUEmail: "",
            nUPhone: "",
            visible: false,
            visible1: false,
            oldPhone: "",
            form: {},
            form1: {},
            dialogFormVisible: false,
            innerVisible: false,
            dialogFormVisible1: false,
            innerVisible1: false,
            formLabelWidth: '120px'
        };
    },
    methods: {
        information() {
            axios({
                method: "post",
                url: "/userInformation"
            }).then((response) => {
                this.uId = response.data.uid;
                this.nUName = this.uName = response.data.uname;
                this.nUEmail = this.uEmail = response.data.uemail;
                this.oldPhone = this.nUPhone = this.uPhone = response.data.uphone;
            })
        },
        bindingPhone() {
            let regPhone = /^1([38]\d|4[5-9]|5[0-35-9]|6[56]|7[0-8]|9[189])\d{8}$/;
            if (regPhone.test(this.nUPhone)) {
                axios(
                    {
                        method: "post",
                        url: "/userUpdateInformation",
                        transformRequest: [
                            function (data) {
                                return parseParams(data);
                            }
                        ],
                        data: {
                            uId: this.uId,
                            uPhone: this.nUPhone
                        }
                    }
                ).then((response) => {
                    if (response.data) {
                        this.dialogFormVisible = false;
                        this.information();
                    } else {
                        this.innerVisible = true;
                    }
                })
            } else {
                this.innerVisible = true;
            }
        },
        updateInformation() {
            let regName = /^[A-Za-z0-9]{4,15}$/;
            let regEmail = /^[A-Za-z0-9]+([_\.][A-Za-z0-9]+)*@([A-Za-z0-9\-]+\.)+[A-Za-z]{2,6}$/;
            let regPhone = /^1([38]\d|4[5-9]|5[0-35-9]|6[56]|7[0-8]|9[189])\d{8}$/;
            if (!this.inputChange()) {
                if (regName.test(this.nUName) && regEmail.test(this.nUEmail)) {
                    axios(
                        {
                            method: "post",
                            url: "/userUpdateInformation",
                            transformRequest: [
                                function (data) {
                                    return parseParams(data);
                                }
                            ],
                            data: {
                                uId: this.uId,
                                uName: this.nUName,
                                uEmail: this.nUEmail
                            }
                        }).then((response) => {
                        if (response.data) {
                            this.information();
                            this.visible = false;
                        } else {
                            this.visible = false;
                            this.updateInformationError();
                        }
                    })
                } else {
                    this.visible = false;
                    this.updateInformationError();
                }
            } else {
                if (regName.test(this.nUName) && regEmail.test(this.nUEmail) && regPhone.test(this.nUPhone)) {
                    axios(
                        {
                            method: "post",
                            url: "/userUpdateInformation",
                            transformRequest: [
                                function (data) {
                                    return parseParams(data);
                                }
                            ],
                            data: {
                                uId: this.uId,
                                uName: this.nUName,
                                uEmail: this.nUEmail,
                                uPhone: this.nUPhone
                            }
                        }).then((response) => {
                        if (response.data) {
                            this.information();
                            this.visible = false;
                        } else {
                            this.visible = false;
                            this.updateInformationPhoneError();
                        }
                    })
                } else {
                    this.visible = false;
                    this.updateInformationPhoneError();
                }
            }
        },
        updateInformationForPassword() {
            let regPwd = /((?=.*\d)(?=.*\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$/;
            if (this.nUPwd === this.aNUPwd && regPwd.test(this.nUPwd)) {
                axios(
                    {
                        method: "post",
                        url: "/userUpdateInformation",
                        transformRequest: [
                            function (data) {
                                return parseParams(data);
                            }
                        ],
                        data: {
                            uId: this.uId,
                            uPwd: this.nUPwd
                        }
                    }).then((response) => {
                    if (response.data) {
                        this.dialogFormVisible1 = false;
                        this.updatePwdSuccess();
                    } else {
                        this.innerVisible1 = true;
                    }
                })
            } else {
                this.innerVisible1 = true;
            }
        },
        updateInformationError() {
            this.$alert('用户名只能包括数字字母的组合，长度为4-15位;', '用户名或邮箱格式错误', {
                confirmButtonText: '确定'
            });
        },
        updateInformationPhoneError() {
            this.$alert('用户名只能包括数字字母的组合，长度为4-15位;手机号可能重复请重新填写', '用户名、邮箱、手机号格式错误', {
                confirmButtonText: '确定'
            });
        },
        inputChange() {
            return this.oldPhone !== this.nUPhone;
        },
        showPhone() {
            return this.nUPhone != null || this.nUPhone !== '';
        },
        updatePwdSuccess() {
            this.$confirm('即将跳转到登录页面', '重置密码成功', {
                confirmButtonText: '确定',
                type: 'success'
            }).then(() => {
                axios.get('userLogout').then(
                    window.location.replace("http://localhost/login")
                );
            }).catch(() => {
                window.location.replace("http://localhost/login")
            })
        },
        updatePasswordPopover() {
            this.visible1 = false;
            this.dialogFormVisible1 = true;
        },
    },
    mounted() {
        this.information();
    },
});
