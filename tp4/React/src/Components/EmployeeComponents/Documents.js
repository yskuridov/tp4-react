import React from "react";
import {useState, useEffect} from "react";

const Documents = () =>{
    const [documents, setDocuments] = useState([]);

    useEffect(() => {
        const getDocuments = async () => {
        const documentsFromServer = await fetchDocuments()
        setDocuments(documentsFromServer)
        }
        getDocuments()
    }, [])

    const fetchDocuments = async () => {
        const res = await fetch('http://localhost:8080/documents')
        const data = await res.json()
        return data;
    }

    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Publication year</th>
                        <th>Language</th>
                        <th>Genre</th>
                        <th>Number of copies</th>
                    </tr>
                </thead>
                <tbody>
                    {documents.map((document) =>
                    <tr key={document.id}>
                        <td>{document.title}</td>
                        <td>{document.publicationYear}</td>
                        <td>{document.language}</td>
                        <td>{document.genre}</td>
                        <td>{document.nbCopies}</td>
                    </tr>)}
                </tbody>
            </table>
        </div>
    )

}

export default Documents