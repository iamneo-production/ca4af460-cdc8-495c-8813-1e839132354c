import React from "react";
import { Navbar, Nav, Form, FormControl, Button, Container } from "react-bootstrap";
import {Link } from "react-router-dom"

class AdminNavbar extends React.Component {
  render() {
    return (
        <div>
          <Navbar bg="dark" variant={"dark"} expand="lg" id="adminNavbar">
            <Container fluid>
              <Navbar.Brand >E-Book</Navbar.Brand>
              <Navbar.Toggle aria-controls="navbarScroll" />
              <Navbar.Collapse id="navbarScroll">
                <Nav
                  className="me-auto my-2 my-lg-0"
                  style={{ maxHeight: '100px' }}
                  navbarScroll
                >
                  <Nav.Link as={Link} to="/admin" id="adminProductButton" >Products</Nav.Link>
                  <Nav.Link as={Link} to="/admin/orders" id="adminOrderButton" >Orders</Nav.Link>



                </Nav>
                <Form className="d-flex">
                  <FormControl
                    type="search"
                    placeholder="Search"
                    className="me-2"
                    aria-label="Search"
                  />
                  <Button variant="outline-success">Search</Button>
                </Form>
                <Nav.Link href="admin/logout" id="logoutButton">LogOut</Nav.Link>
              </Navbar.Collapse>
            </Container>
          </Navbar>
        </div>
    );
  }
}
export default AdminNavbar;