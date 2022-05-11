import React from "react";
import AddBook from "./AddBook";
import {NavLink} from "react-router-dom";


const Employee = () => (
    <div>
        <h1>Employee</h1>
        <div>
            <button>
                <NavLink to="/employee/addBook">Add a book</NavLink>
            </button>
            <button>
                <NavLink to="/employee/addCd">Add a CD</NavLink>
            </button>
        </div>

    </div>


)

export default Employee;