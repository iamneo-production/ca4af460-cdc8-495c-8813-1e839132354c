import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import "./myaccount.css";
import { Button } from "@mui/material";
import { Form } from "react-bootstrap";
import axios from "axios";

export default function FormPropsTextFields() {
  const [fname,setFname] = React.useState('')
  const [lname,setLname] = React.useState('')
  const [email,setEmail] = React.useState('')
  const [mobile,setMobile] = React.useState('')
  const [address,setAddress] = React.useState('')
  const [state,setState] = React.useState('')
  const [city,setCity] = React.useState('')
  const [zipcode,setZipcode] = React.useState('')
  const handleSubmit = () =>{
    console.log("........Pressed........")
    const userObj = {fname,lname,email,mobile,address,state,city,zipcode}
    axios.post('localhost:8000/editUser',userObj)
  }
  return (
    <Form>
    <Box
      className="boxx"
      component="form"
      sx={{
        "& .MuiTextField-root": { m: 1, width: "25ch" },
      }}
      noValidate
      autoComplete="off"
    >
      <div>
        {/* <div className="editp"> */}
        {/* <Button sx={{ m: 1, minWidth: 80 }} >Edit Profile</Button></div> */}
        <div className="imgstyle">
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnPL1zW3xWnLePHIci-FRr8YsFF0Kh99rq3q9F4F_GJHu-dCxb7E2ZKsEEOF7LcsPgynU&usqp=CAU"
          alt="profileimgage"
        />
        </div>
        <br />
        <TextField required onChange={(e)=> setFname(e.target.value)} value={fname} id="outlined-required" name="fname" label="First Name" />
        <TextField required onChange={(e)=> setLname(e.target.value)} value={lname} id="outlined-required" lname="lname" label="Last Name" />
        <br />
        <TextField onChange={(e)=> setEmail(e.target.value)} value={email} id="outlined-email-input" label="E-mail" name="email" type="email" />
        <br />

        <TextField
          id="outlined-number"
          label="Mobile"
          type="number"
          name="mobile"
          inputProps={{ maxLength: 10}}
          onChange={(e)=> setMobile(e.target.value)} value={mobile}
        />
      </div>
      <div>
        <h1>Location Details</h1>
        <div className="coladd">
          <TextField
            id="outlined-multiline-static"
            label="Address"
            name="address"
            multiline
            rows={4}
            onChange={(e)=> setAddress(e.target.value)} value={address}
          />
          <br />
          <TextField onChange={(e)=> setState(e.target.value)} value={state} name="state" required id="outlined-state" type="text" label="State" />
          <br />
          <TextField onChange={(e)=> setCity(e.target.value)} value={city} name="city" required id="outlined-required" type="text" label="City" />
          <TextField onChange={(e)=> setZipcode(e.target.value)} value={zipcode} name="zipcode" required id="outlined-zip" type="number" label="Zipcode" />
        </div>
      </div>
      <div className="buttons">
        <Button onClick={handleSubmit} id="saveb">Save Changes</Button>
      </div>
    </Box>
    </Form>
  );
}
