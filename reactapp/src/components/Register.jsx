import React, { useState } from 'react'
import { Avatar, Button, Grid, Paper, TextField, Typography } from '@material-ui/core';
import { Link } from 'react-router-dom';
import { useHistory } from "react-router-dom";

const Register = () => {
    const paperStyle = { padding: 50, height: '62vh', width: 300, margin: "20 auto" }
    const avtarStyle = { backgroundColor: 'blue' }
    const btnStyle = { margin: '20px 0' }
    const history = useHistory()

    const url = ""
    const [userDetails, setUserDetails] = useState({
        email: "",
        username: "",
        mobilenumber: "",
        password: "",
        confirmpassword: ""
    })
    const [isUserExist, setUserExist] = useState([false])

    function submit(e) {
        e.preventDefault();
        fetch(url,
            {
                method: 'POST',
                body: {
                    email: userDetails.email,
                    username: userDetails.username,
                    mobilenumber: userDetails.mobilenumber,
                    password: userDetails.password,
                }
            }).then(res => {
                setUserExist(res);
                if (!isUserExist) {
                    history.push("/login")
                }
            })
            .catch((error) => {
                console.log(error)
            });
    }

    function handle(e) {
        const newdata = { ...userDetails }
        newdata[e.target.id] = e.target.value
        setUserDetails(newdata)
    }




    return (
        <Grid align='center'>
            <Paper style={paperStyle}>
                <Grid align='center'>
                    <Avatar style={avtarStyle}>
                    </Avatar>
                    <h2>REGISTER</h2>
                </Grid>
                <form onSubmit={(e) => submit(e)} id='signupBox'>
                    <TextField onChange={(e) => handle(e)} value={userDetails.email} type='email' id='email' label='Email' placeholder='Enter Email Id' fullWidth required />
                    <TextField onChange={(e) => handle(e)} value={userDetails.username} id='username' label='UserName' placeholder='Enter UserNAme' fullWidth required />

                    <TextField onChange={(e) => handle(e)} value={userDetails.mobilenumber} id='mobilenumber' inputProps={{ maxLength: 10 }} label='Mobile No.' placeholder='Enter Mobile No.' fullWidth required />
                    <TextField onChange={(e) => handle(e)} value={userDetails.password} id='password' type='password' label='Password' placeholder='Enter Password' fullWidth required />
                    <TextField onChange={(e) => handle(e)} value={userDetails.confirmpassword} id='confirmpassword' type='password' label='Confirm Password' placeholder='Confirm Password' fullWidth required />
                    <Button id='submitButton' type='submit' color='primary' variant='contained' style={btnStyle} fullWidth>REGISTER</Button>
                </form>
                <Typography>
                    Already a member?
                    <Link id='signinLink' to='/login'>
                        LOGIN
                    </Link>
                </Typography>
            </Paper>
        </Grid>
    )
}

export default Register;