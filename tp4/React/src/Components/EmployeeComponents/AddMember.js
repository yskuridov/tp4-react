import {useState} from "react";

const AddMember = ({OnAdd}) => {
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [address, setAddress] = useState('')


    const onSubmit = async (event) => {
        event.preventDefault();
        const member = {firstName, lastName, address}
        await fetch("http://localhost:8080/documents/cds",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(member)
        })
        setFirstName('')
        setLastName('')
        setAddress('')
    }

    return (
        <form onSubmit={onSubmit}>
            <div className='form-control'>
                <label>First Name</label>
                <input type='text'
                       value={firstName}
                       onChange={(e) => setFirstName(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Last Name</label>
                <input type='text'
                       value={lastName}
                       onChange={(e) => setLastName(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Address</label>
                <input type='text'
                       value={address}
                       onChange={(e) => setAddress(e.target.value)} />
            </div>
            <input type='submit' value='Save Member'/>
        </form>
    )
}

export default AddMember