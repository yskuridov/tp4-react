import {useState} from "react";

const AddCd = ({OnAdd}) => {
    const [title, setTitle] = useState('')
    const [publicationYear, setPublicationYear] = useState('')
    const [language, setLanguage] = useState('')
    const [singer, setSinger] = useState('')
    const [nbOfTracks, setNbOfTracks] = useState('')
    const [genre, setGenre] = useState('')
    const [nbCopies, setNbCopies] = useState('')


    const onSubmit = async (event) => {
        event.preventDefault();
        const cd = {title, publicationYear, language, singer, nbOfTracks, genre, nbCopies}
        await fetch("http://localhost:8080/documents/cds",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(cd)
        })
        setTitle('')
        setPublicationYear('')
        setLanguage('')
        setSinger('')
        setNbOfTracks('')
        setGenre('')
        setNbCopies('')
}

return (
    <form onSubmit={onSubmit}>
        <div className='form-control'>
            <label>Title</label>
            <input type='text'
                   value={title}
                   onChange={(e) => setTitle(e.target.value)} />
        </div>
        <div className='form-control'>
            <label>Publication year</label>
            <input type='number'
                   value={publicationYear}
                   onChange={(e) => setPublicationYear(e.target.value)} />
        </div>
        <div className='form-control'>
            <label>Language</label>
            <input type='text'
                   value={language}
                   onChange={(e) => setLanguage(e.target.value)} />
        </div>
        <div className='form-control'>
            <label># of copies</label>
            <input type='number'
                   value={nbCopies}
                   onChange={(e) => setNbCopies(e.target.value)} />
        </div>
        <div className='form-control'>
            <label>Singer</label>
            <input type='text'
                   value={singer}
                   onChange={(e) => setSinger(e.target.value)} />
        </div>
        <div className='form-control'>
            <label># of tracks</label>
            <input type='number'
                   value={nbOfTracks}
                   onChange={(e) => setNbOfTracks(e.target.value)} />
        </div>
        <div className='form-control'>
            <label>Genre</label>
            <input type='text'
                   value={genre}
                   onChange={(e) => setGenre(e.target.value)} />
        </div>
        <input type='submit' value='Save CD'/>
    </form>
)
}

export default AddCd