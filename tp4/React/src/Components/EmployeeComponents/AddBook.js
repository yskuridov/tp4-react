import {useState} from "react";

const AddBook = ({OnAdd}) => {
    const [title, setTitle] = useState('')
    const [publicationYear, setPublicationYear] = useState('')
    const [language, setLanguage] = useState('')
    const [nbCopies, setNbCopies] = useState('')
    const [author, setAuthor] = useState('')
    const [editor, setEditor] = useState('')
    const [pageAmount, setPageAmount] = useState('')
    const [genre, setGenre] = useState('')

    const onSubmit = async (event) => {
        event.preventDefault();
        const book = {title, publicationYear, language, nbCopies, author, editor, pageAmount, genre}
        await fetch("http://localhost:8080/documents/books",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body: JSON.stringify(book)
        }).then(console.log())
        setTitle('')
        setPublicationYear('')
        setLanguage('')
        setNbCopies('')
        setAuthor('')
        setEditor('')
        setPageAmount('')
        setGenre('')
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
                <label>Author</label>
                <input type='text'
                       value={author}
                       onChange={(e) => setAuthor(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Editor</label>
                <input type='text'
                       value={editor}
                       onChange={(e) => setEditor(e.target.value)} />
            </div>
            <div className='form-control'>
                <label># of pages</label>
                <input type='number'
                       value={pageAmount}
                       onChange={(e) => setPageAmount(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Genre</label>
                <input type='text'
                       value={genre}
                       onChange={(e) => setGenre(e.target.value)} />
            </div>
            <input type='submit' value='Save Book'/>
        </form>
    )
}

export default AddBook