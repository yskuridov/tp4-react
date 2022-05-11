import React from "react";
import {NavLink} from "react-router-dom";

const HomePage = () => (
    <div>
        <h1>Javatown Library</h1>
        <h3>Select your type of access: </h3>
        <NavLink to="/member">
            <button type="button">
                Click Me!
            </button>
        </NavLink>
        <NavLink to="/employee">
            <button type="button">
                Click Me!
            </button>
        </NavLink>
    </div>
)

export default HomePage