import React, { useState } from "react";

import './Login.css'
import {baseURL} from ".././../index";



function Login() {
    return (
        <div className="app">
            <div className="login-form">
                <div className="title">Sign In</div>
                <form action="" method={"POST"}>
                    <div>
                        <label htmlFor="say">What greeting do you want to say?</label>
                        <input name="say" id="say"/>
                    </div>
                    <br/>
                    <div>
                        <label htmlFor="to">Who do you want to say it to?</label>
                        <input name="to" id="to"/>
                    </div>
                    <br/>
                    <div>
                        <button>Send my greetings</button>
                    </div>

                </form>
            </div>
        </div>
    );
}

export default Login