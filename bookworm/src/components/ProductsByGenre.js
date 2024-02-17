import { Button, ButtonGroup, Container } from "react-bootstrap";
import MyCard from "./MyCard";
import { useState } from "react";

export default function ProductsByGenre({ val, languages }) {
    const [language, setLanguage] = useState(null);

    const handleClick = (languageId) => {
        setLanguage(languageId);
    }

    return (
        <>
            <Container className="justify-content-center">
                <ButtonGroup aria-label="Basic example">
                    <Button variant="secondary" onClick={() => setLanguage(null)}>All Languages</Button>
                    {languages.map(lang => (
                        <Button variant="secondary" onClick={() => handleClick(lang.languageId)}>{lang.languageDesc}</Button>
                    ))}
                </ButtonGroup>
                <MyCard typeId={val.typeId} selectedLanguage={language}></MyCard>
            </Container>
        </>
    );
}
