<template>
    <div class="loginRoot">
        <!-- el-image 默认 position 为 relative, 需要在 style 中修改为 absolute -->
        <el-image class="bgImg" :src="src" fit="cover" style="position:absolute;"/>
        <el-container class="elCon">
            <el-main style="padding: 0;">
                <div class="loginCon">
                    <div class="loginLayout">
                        <div class="contentCon" style="padding: 0 50px 0 50px; height: 100%;">
                            <el-image class="logoImgLogin" :src="logoLoginSrc" style="position:relative;"/>
                            <div id="sloganTitle" class="sloganTitle">{{sloganTitle}}</div>
                            <div class="userCon">
                                <input id="username" class="form-control" name="username" placeholder="输入用户名"
                                       required="required"/>
                            </div>
                            <div class="passCon">
                                <input id="password" class="form-control" name="pass" placeholder="输入密码"
                                       type="password" required="required"/>
                            </div>
                            <div class="doLoginCon">
                                <el-row class="el-row-col">
                                    <el-col class="el-row-col-l" :span="12">
                                        <a class="forgetPass" v-on:click="forgetPassword">忘记密码?</a>
                                    </el-col>
                                    <el-col class="el-row-col-r" :span="12">
                                        <button class="loginBtn" id="loginBtn" v-on:click="tryLogin">登录</button>
                                    </el-col>
                                </el-row>
                            </div>
                            <el-divider style="height: 60px; color: white; background-color: black">其他登录方式</el-divider>

                            <div class="otherLoginCon">
                                <a class="otherLogin" v-on:click="notSupport()">
                                    <span class="iconfont icon-qq2 qqLogin" style="font-size: 40px;"/>
                                </a>
                                <a class="otherLogin" v-on:click="notSupport()">
                                    <span class="iconfont icon-weixin1" style="font-size: 40px;"/>
                                </a>
                                <a class="otherLogin" v-on:click="notSupport()">
                                    <span class="iconfont icon-zhifubao" style="font-size: 40px;"/>
                                </a>
                                <a class="otherLogin" v-on:click="notSupport">
                                    <span class="iconfont icon-taobao1" style="font-size: 40px;"/>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </el-main>
            <el-footer style="padding: 0;">
                <div class="footerLayout">
                    <span class="login_record-text" id="rights" v-html="rights"/>
                </div>
            </el-footer>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            let date = new Date();
            let year = date.getFullYear();
            return {
                rights: 'Copyright&nbsp;&copy; 2020-' + year + '. &nbsp;www.gyarcu.com&nbsp;&nbsp;&nbsp;\
                            <a class="record-link" href="http://beian.miit.gov.cn/" target="_blank">皖ICP备20001302号-1</a>\
                       ',
                // src: require("../assets/bg_bank_card.png"),
                src: "/vue_ser_pic/picture/bg_login_arcu.png",
                logoLoginSrc: "/vue_ser_pic/picture/img_arcu_logo_horizontal_trans_white_font.png",
                // sloganTitle: "农 为 本, 商 有 道, 行 致 远",
                sloganTitle: "涡阳农商行综合管理系统 Web",
                username: "",
                password: "",
                layer: null,
            }
        },
        created() {
            // this.layer = window.layer;
            // this.layer = window.layui.layer;
        },
        mounted() {
            this.$nextTick(() => {
                // this.layer = window.layer;
                this.layer = window.layui.layer;
                // console.log(window.layui);
            });
            // this.layer = window.layer;
            // this.layer = window.layui.layer;

            // 下面语句可用
            // this.$jQuery("#sloganTitle").html("123456hehe");
        },
        methods: {
            notSupport: function () {
                this.layer.alert('即将开通第三方登录方式，敬请期待!');
                // layer.open({
                //     type: 0,
                //     content: "暂未开通第三方登录方式" //这里content是一个普通的String
                // });
            },
            tryLogin: function () {
                console.log("登录");
            },
            forgetPassword: function () {
                this.layer.alert('即将开通敬请期待');
            }
        }
    }

    function loadSysMsg(vueThis) {
        let param = {
            username: "admin",
            password: "123456"
        };
        vueThis.$axios.post('/testCon/login',
            vueThis.$qs.stringify(param),
            {headers: vueThis.global.postHeadersUrlEn}
        ).then(successResponse => {
            // console.log(successResponse);
            // console.log(successResponse.status);
            if (successResponse.status === 200) {
                // console.log('200, 成功');
                setTimeout(() => {
                    vueThis.$router.push('/');
                }, 3000);
            }
        }).catch(failResponse => {
            console.log('登录失败');
            console.log(failResponse);
        })
    }
</script>

<style>
    @import "../sources/css/login.css";
</style>