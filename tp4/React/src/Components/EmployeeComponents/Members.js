import React from "react";
import {useState, useEffect} from "react";

const Members = () =>{
    const [members, setDocuments] = useState([]);

    useEffect(() => {
        const getMembers = async () => {
            const membersFromServer = await fetchMembers()
            setMembers(membersFromServer)
        }
        getMembers()
    }, [])

    const fetchMembers = async () => {
        const res = await fetch('http://localhost:8080/members')
        const data = await res.json()
        return data;
    }

    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                </tr>
                </thead>
                <tbody>
                {members.map((member) =>
                    <tr key={member.id}>
                        <td>{member.firstName}</td>
                        <td>{member.lastName}</td>
                        <td>{member.address}</td>
                    </tr>)}
                </tbody>
            </table>
        </div>
    )

}

export default Members