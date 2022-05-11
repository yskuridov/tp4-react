import {useState} from "react";

const AddDvd = ({OnAdd}) => {
    const [title, setTitle] = useState('')
    const [publicationYear, setPublicationYear] = useState('')
    const [language, setLanguage] = useState('')
    const [duration, setDuration] = useState('')
    const [genre, setGenre] = useState('')
    const [mainActor, setMainActor] = useState('')
    const [nbCopies, setNbCopies] = useState('')


    const onSubmit = async (event) => {
        event.preventDefault();
        const dvd = {title, publicationYear, language, duration, genre, mainActor, nbCopies}
        await fetch("http://localhost:8080/documents/cds",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(dvd)
        })
        setTitle('')
        setPublicationYear('')
        setLanguage('')
        setDuration('')
        setGenre('')
        setMainActor('')
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
                <label>Duration in minutes</label>
                <input type='number'
                       value={duration}
                       onChange={(e) => setDuration(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Genre</label>
                <input type='text'
                       value={genre}
                       onChange={(e) => setGenre(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Main Actor</label>
                <input type='text'
                       value={mainActor}
                       onChange={(e) => setMainActor(e.target.value)} />
            </div>
            <input type='submit' value='Save CD'/>
        </form>
    )
}

export default AddDvd