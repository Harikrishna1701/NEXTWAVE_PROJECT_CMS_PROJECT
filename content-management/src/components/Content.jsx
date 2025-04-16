import React, { useState, useEffect } from 'react';
import './content.css';
import bgImage from './assets/bg-image.png';

const Content = () => {
  const [isEditing, setIsEditing] = useState(false);
  const [heading, setHeading] = useState(
    "Hyper boost your Revenue Management, Marketing and Commercial Functions with Business Ready AI"
  );
  const [tempHeading, setTempHeading] = useState(heading);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch('http://localhost:9191/api/heading')
      .then((response) => response.json())
      .then((data) => {
        if (data.heading) {
          setHeading(data.heading);
          setTempHeading(data.heading);
        }
        setLoading(false);
      })
      .catch((error) => console.error('Error fetching heading:', error));
  }, []);

  const handleSave = () => {
    fetch('http://localhost:9191/api/heading', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ heading: tempHeading })
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.heading) {
          setHeading(data.heading);
        }
        setIsEditing(false);
      })
      .catch((error) => {
        console.error('Error updating heading:', error);
        setIsEditing(false);
      });
  };

  if (loading) {
    return <p>Loading...</p>; // Loading UI
  }

  return (
    <div className="container">
      {/* Left content */}
      <div className="content-left">
        {!isEditing ? (
          <>
            <div className="temporary-content">
              <h2>
                {heading.split(' ').map((word, index) => (
                  <span key={index} className={word === 'Revenue' || word === 'Marketing' ? 'highlight' : ''}>
                    {word + ' '}
                  </span>
                ))}
              </h2>
            </div>

            <div className="fixed-content">
              <p>
                Powerful AI Solutions that go beyond mere data sorting and <br />
                exploration. Use our array of AI enabled solutions that understand <br />
                your business and recommend the optimal way forward.
              </p>
            </div>

            <div className="fixed-button">
              <button className="button" onClick={() => setIsEditing(true)}>Get Started</button>
            </div>
          </>
        ) : (
          <div className="edit-section">
            <label>Edit Heading</label>
            <textarea
              value={tempHeading}
              onChange={(e) => setTempHeading(e.target.value)}
              rows="4"
              cols="50"
            />
            <div className="button-row">
              <button onClick={() => setIsEditing(false)}>Cancel</button>
              <button onClick={handleSave}>Save</button>
            </div>
          </div>
        )}
      </div>

      <img src={bgImage} alt="hero" className='image-right' />
    </div>
  );
};

export default Content;