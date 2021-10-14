import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import "./myaccount.css";
import { Button } from "@mui/material";

export default function FormPropsTextFields() {
  return (
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
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnPL1zW3xWnLePHIci-FRr8YsFF0Kh99rq3q9F4F_GJHu-dCxb7E2ZKsEEOF7LcsPgynU&usqp=CAU"
          alt="profileimgage"
          className="imgstyle"
        />
        <br />
        <TextField required id="outlined-required" label="First Name" />
        <TextField required id="outlined-required" label="Last Name" />
        <br />
        <TextField id="outlined-email-input" label="E-mail" type="email" />
        <br />

        <TextField
          id="outlined-number"
          label="Mobile"
          type="text"
          maxLength="10"
        />
      </div>
      <div>
        <h1>Location Details</h1>
        <div className="coladd">
          <TextField
            id="outlined-multiline-static"
            label="Address"
            multiline
            rows={4}
          />
          <br />
          <TextField required id="outlined-state" type="text" label="State" />
          <br />
          <TextField required id="outlined-required" type="text" label="City" />
          <TextField required id="outlined-zip" type="number" label="Zipcode" />
        </div>
      </div>
      <div className="buttons">
        <Button id="saveb">Save Changes</Button>
      </div>
    </Box>
  );
}
