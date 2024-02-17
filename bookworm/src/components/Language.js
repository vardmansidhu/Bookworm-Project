import { useEffect, useState } from 'react';
import { ButtonToolbar } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';


export default function Language({ setSelectedLanguage, typeId }) {
    const [languageType, setLanguageType] = useState([]);
    //const [selectedLanguage, setSelectedLanguage] = useState(null);

    // useEffect(() => {
    //     fetch(`http://localhost:8080/api/language/getByTypeId/2`)
    //     .then(res=>alert(res))
    //         // .then((res) => res.json())
    //         // .then((data) => setLanguageType(data))
    // }, [typeId]);
    const handleLanguageClick = (languageId) => {
        setSelectedLanguage(languageId);
    };
    
    return (
        <>
            <ButtonToolbar
                className="justify-content-center"
                aria-label="Toolbar with Button groups"
            >
                <ButtonGroup aria-label="Basic example">
                    {languageType.map((language) => (
                        <Button key={language.languageId} variant="secondary"
                        onClick={() => handleLanguageClick(language.languageId)}
                        >
                            {language.languageDesc}
                        </Button>
                    ))}
                </ButtonGroup>
            </ButtonToolbar>
             {/* {selectedLanguage && <MyLang typeId={typeId} langId={selectedLanguage} />} */}
        </>

    );
}
